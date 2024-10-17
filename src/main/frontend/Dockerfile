FROM node:15-alpine
WORKDIR /app
COPY package.json /app/package.json
RUN npm install -g npm@10.9.0
COPY . ./
RUN npm run build
CMD ["npm", "start"]