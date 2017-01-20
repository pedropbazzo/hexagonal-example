FROM jboss/wildfly

# Adiciona admin
RUN $JBOSS_HOME/bin/add-user.sh admin admin@123 --silent

# Aplicando customizações do JBOSS através do JBOSS CLI batch
COPY wildfly/config.cli $JBOSS_HOME/bin/config.cli
RUN cd $JBOSS_HOME/bin && sh jboss-cli.sh --file=config.cli
RUN rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history

# Deploy
COPY target/bookmark-service-0.0.1-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

EXPOSE 8787 9990 9999
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "--debug"]