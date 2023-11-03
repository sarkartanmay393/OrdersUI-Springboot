#!/bin/bash

cd orderlist-ui
npm install
npm run build

cd ..
cp -R ./orderlist-ui/build/* ./backend/src/main/resources/static
cd backend
mvn install
mvn spring-boot:run