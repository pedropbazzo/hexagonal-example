bookmark-install:
	mvn clean install -f bookmark-context/bookmark

bookmark-service-build:
	mvn clean install -f bookmark-context/bookmark-service \
	&& docker build -t bookmark-service-wildfly bookmark-context/bookmark-service

bookmark-service:
	docker run -it --rm -p 8080:8080 -p 9990:9990 -p 8787:8787 --name bookmark-service-wildfly bookmark-service-wildfly

bookmark-web-build:
	docker build -t bookmark-web-html-httpd bookmark-context/bookmark-web-html

bookmark-web:
	docker run -i --rm -p 80:80 --name bookmark-web-html bookmark-web-html-httpd


	