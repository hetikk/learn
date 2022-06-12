include ./extension/Makefile

extension-build:
	@ cd ./extension/ && make build-extension

extension-install:
	@ cd ./extension/ && make install-extension

extension-update:
	@ cd ./extension/ && make update-extension

extension-remove:
	@ docker extension rm $(IMAGE):$(TAG)

extension-start-ui-app:
	@ cd ./extension/ui && npm start

extension-start-dev:
	@# docker extension dev ui-source $(IMAGE):$(TAG) http://localhost:3000
	@ docker extension dev ui-source hetikk/learn-extension:latest http://localhost:3000


