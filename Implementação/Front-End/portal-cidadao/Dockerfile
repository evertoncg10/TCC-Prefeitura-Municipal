# Instalação ambiente node
FROM node:14.15-alpine3.10 as node
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm i npm@latest -g
RUN npm install
COPY . .
RUN npm run build

# Instalação NGINX
FROM nginx:1.18.0-alpine
COPY --from=node /usr/src/app/dist/portal-cidadao /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf