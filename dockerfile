FROM java:8

ARG buildInfo=1.0.0
ENV DOCKER_BUILD_INFO ${buildInfo}
VOLUME /tmp
ADD entrypoint.sh entrypoint.sh
ADD build/libs/springbootDeamo-0.0.1-SNAPSHOT.jar springbootDemo.jar
RUN bash -c 'touch /springbootDemo.jar'
RUN chmod +x entrypoint.sh
ENTRYPOINT ["./entrypoint.sh"]