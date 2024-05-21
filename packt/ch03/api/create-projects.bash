#!/usr/bin/env bash

spring init \
--boot-version=3.1.11 \
--build=gradle \
--type=gradle-project \
--java-version=17 \
--packaging=jar \
--name=product \
--package-name=edu.learning.api.core.product \
--groupId=edu.learning.api.core.product \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
product

spring init \
--boot-version=3.1.11 \
--build=gradle \
--type=gradle-project \
--java-version=17 \
--packaging=jar \
--name=review \
--package-name=edu.learning.api.core.review \
--groupId=edu.learning.api.core.review \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
review

spring init \
--boot-version=3.1.11 \
--build=gradle \
--type=gradle-project \
--java-version=17 \
--packaging=jar \
--name=recommendation \
--package-name=edu.learning.api.core.recommendation \
--groupId=edu.learning.api.core.recommendation \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
recommendation