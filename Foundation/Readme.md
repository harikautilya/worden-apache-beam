# Setup

## Intial Setup
1. Create a google account
2. Enabled Cloud Resource Manager API api
3. Update the project id in pulumi.dev.yaml  

## Runtime setup
This has to be perfomed every time

1. `gcloud auth login` for login into gcloud
2. `gcloud auth application-default login` for using ADC
3. `pulumi up` to setup the infra