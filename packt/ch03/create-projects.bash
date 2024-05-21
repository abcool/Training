#!/usr/bin/env bash

mkdir microservices
cd microservices

spring init \
--boot-version=3.1.11 \
--build=gradle \
--type=gradle-project \
--java-version=17 \
--packaging=jar \
--name=product-service \
--package-name=edu.learning.microservices.core.product \
--groupId=edu.learning.microservices.core.product \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
product-service

spring init \
--boot-version=3.1.11 \
--build=gradle \
--type=gradle-project \
--java-version=17 \
--packaging=jar \
--name=review-service \
--package-name=edu.learning.microservices.core.review \
--groupId=edu.learning.microservices.core.review \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
review-service

spring init \
--boot-version=3.1.11 \
--build=gradle \
--type=gradle-project \
--java-version=17 \
--packaging=jar \
--name=recommendation-service \
--package-name=edu.learning.microservices.core.recommendation \
--groupId=edu.learning.microservices.core.recommendation \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
recommendation-service

spring init \
--boot-version=3.1.11 \
--build=gradle \
--type=gradle-project \
--java-version=17 \
--packaging=jar \
--name=product-composite-service \
--package-name=edu.learning.microservices.composite.product \
--groupId=edu.learning.microservices.composite.product \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
product-composite-service

cd ..