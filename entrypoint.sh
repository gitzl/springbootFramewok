#!/usr/bin/env bash
echo 'Start springbootDeamo Application....'
java -Xmx1024m -Djava.security.egd=file:/dev/./urandom -jar springbootDemo.jar $@