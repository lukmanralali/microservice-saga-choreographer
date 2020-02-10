FROM node:12-alpine

RUN apk update && \
    apk add bash && \
    apk add gcc && \
    apk add musl-dev && \
    apk add curl && \
    apk add python && \
    apk add g++

RUN mkdir -p /usr/src/node/app/node_modules && chown -R node:node /usr/src/node/app
ADD . /usr/src/node/app
WORKDIR /usr/src/node/app
RUN ls -la
RUN pwd
RUN npm install
# CMD [ "npm", "start" ]