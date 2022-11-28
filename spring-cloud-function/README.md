# Spring Cloud Function
Cloud Native Dev Hands-on 
## Buildpacks ([https://buildpacks.io/docs/tools/pack/](https://buildpacks.io/docs/tools/pack/))
```shell
brew install buildpacks/tap/pack
pack build parser-service --builder docker.io/paketobuildpacks/builder:base --env BP_JVM_VERSION=17
# or
mvn spring-boot:build-image

```
## GraalVM Native Image

## Knative ([https://knative.dev/](https://knative.dev/))