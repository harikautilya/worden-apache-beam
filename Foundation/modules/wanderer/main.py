from pulumi import ComponentResource, ResourceOptions
from pulumi_gcp import pubsub
from modules.wanderer.utils import topic_schema
from modules.core.main import BaseInput


class WandererInputs(BaseInput):
    topic_name: str = "dataflow_read_book"


# Ref : https://www.pulumi.com/registry/packages/gcp/api-docs/pubsub/
class WandererCompoent(ComponentResource):

    def __init__(
        self,
        name: str = "wanderer",
        input: WandererInputs = WandererInputs(),
        opts: ResourceOptions = None,
    ):
        super().__init__(f"{input.project_name}:wanderer:main", name, None, opts=opts)
        self.provison_topic_for_reading(input=input)

    # GCP PUBSUB
    # Actual Schema : Wanderer/Docs/system.md
    def provison_topic_for_reading(self, input: WandererInputs):
        schema = pubsub.Schema(
            "wanderer-book-topic-schema",
            name=f"{input.topic_name}_schema",
            type="AVRO",
            definition=topic_schema,
        )
        topic = pubsub.Topic(
            "wanderer-book-topic",
            name=input.topic_name,
            schema_settings={"schema": schema.id, "encoding": "JSON"},
            opts=ResourceOptions(depends_on=[schema]),
        )

        self.register_outputs({"topic_name": topic.id})
