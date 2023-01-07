# Cloud Native Buildpacks

## Install Buildpacks
```shell
brew install buildpacks/tap/pack
```
## Package application using Buildpacks CLI
```shell
pack build demo-service --builder docker.io/paketobuildpacks/builder:base --env BP_JVM_VERSION=17
```

## Package application using Maven
```shell
mvn spring-boot:build-image -Dspring-boot.build-image.imageName=demo-service
```