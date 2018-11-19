FROM node:alpine
#node apline image
WORKDIR /usr/local/service
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 3000
CMD ["npm","start"]
