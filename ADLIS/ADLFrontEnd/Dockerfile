# Stage 1
FROM node:10-alpine as build-step
RUN mkdir -p /app
WORKDIR /app
COPY package.json /app
COPY .npmrc .npmrc
RUN npm install
RUN rm -f .npmrc
COPY . /app
RUN npm run build --prod

# Stage 2
FROM nginx:1.17.1-alpine
COPY --from=build-step /app/dist/ADLFrontEnd/ /usr/share/nginx/html
