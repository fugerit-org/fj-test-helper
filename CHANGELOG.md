# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [0.5.2] - 2023-09-24

### Changed

- jersey dependency set to default scope in module fj-test-helper-java-jaxrs

## [0.5.1] - 2023-09-24

### Added

- Code of conduct badge and file
- badges for sonar cloud, license, maven repo central and changelog
- [Sample jdk compatibility check workflow on branch develop](.github/workflows/build_maven_compatibility.yml)
- fj-test-helper-java-jaxrs module

### Changed

- [Sonar cloud workflow merged in maven build](.github/workflows/deploy_maven_package.yml)
- fj-bom version set to 1.4.2

### Removed

- Sonar cloud workflow yml removed. (after being merged with maven build)

## [0.5.0] - 2023-09-11

### Added

- [workflow deploy on branch](.github/workflows/deploy_maven_package.yml) (#2)
- Changelog style based on : [https://github.com/olivierlacan/keep-a-changelog](https://github.com/olivierlacan/keep-a-changelog)
- New function API in BasicTest (runTestEx, runTestSilent, runTestCustom based on SafeFunction.apply())

### Changed

- fj-bom set to 1.3.6
- fj-core set to 8.2.7
