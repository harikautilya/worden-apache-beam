from pulumi import ComponentResource, ResourceOptions
from pulumi_gcp import pubsub
from modules.wanderer.utils import topic_schema
from modules.core.main import BaseInput


class WandererInputs(BaseInput):
    topic_name: str = "dataflow_read_book"


class WandererCompoent(ComponentResource):

    def __init__(
        self,
        name: str,
        input: WandererInputs = WandererInputs(),
        opts: ResourceOptions = None,
    ):
        super().__init__(f"{input.project_name}:wanderer:main", name, None, opts=opts)

    # GCP PUBSUB
    # Actual Schema : Wanderer/Docs/system.md
    def provison_topic_for_reading(self, input: WandererInputs):
        schema = pubsub.Schema(
            name=input.topic_name, type="AVRO", definition=topic_schema
        )
