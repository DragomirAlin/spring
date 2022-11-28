# Spring Cloud Function
Cloud Native Dev Hands-on 
## Buildpacks ([https://buildpacks.io/docs/tools/pack/](https://buildpacks.io/docs/tools/pack/))
```shell
brew install buildpacks/tap/pack
pack build parser-service --builder gcr.io/paketo-buildpacks/maven:latest --env BP_JVM_VERSION=17
```
## GraalVM Native Image

## Knative ([https://knative.dev/](https://knative.dev/))