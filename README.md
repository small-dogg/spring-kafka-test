# Overview

본 프로젝트는 kafka를 도커로 구축하고, 구축된 kafka 환경을 기반으로 프로듀서와 컨슈머를 Spring kafka를 통해 테스트하기 위한 용도이다.

본 프로젝트에서는 실무환경에서 사용할법한 형태의 카프카 환경을 구성하는게 목표이다.
브로커의 멀티클러스터 환경까지는 아니더라도 여러 토픽 그리고 컨슈머 그룹간의 데이터 파이프라인 형태를 이해하고 구성해봄으로써,
실무에서의 안정적인 카프카 환경 구성을 고려할 수 있는 시각을 넓히는 것에 초점을 둔다.

# 시작하기
본 프로젝트는 kafka-docker를 제공하기 위해, wurstmeister/kafka 도커 이미지를 사용하여 배포할 수 있도록 이를 제공한다.
https://hub.docker.com/r/wurstmeister/kafka/

## Prerequisite
배포 환경 : Windows를 기반함
필수 설치 App : Docker, Docker-compose(Docker Desktop 설치 시 자동 설치)

## 주의 사항
본 프로젝트에서는 kafka-docker 디렉터리 내 존재하는 docker-compose-single-broker.yml을 사용한다.
만약 멀티 환경으로 구성한다면, 상기 링크를 확인하라.

- 사용 포트(Default) :
  - Kafka : 9092
  - Zookeeper : 2181

## docker 이미지 배포
최상위 디렉터리 내 존재하는 kafka-docker 디렉터리에 접근하여, docker-compose 커맨드를 이용해 배포한다.
```shell
cd ./kafka-docker
docker-compose -f docker-compose-single-broker.yml up
```