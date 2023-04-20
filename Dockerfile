FROM openjdk:11

WORKDIR /app

COPY . .

RUN mkdir -p bin

CMD ["bash"]
