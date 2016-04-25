#!/bin/bash

#Config your java home
#JAVA_HOME=/opt/jdk/

#if [ -z "$JAVA_HOME" ]; then
#  export JAVA=`which java`
#else
  #export JAVA="$JAVA_HOME/bin/java"
  export JAVA=java
#fi
export BASE_DIR=/services/apps/dspmetadata
UEAP_HOME=$BASE_DIR
SERVER_NAME="metadata"
STARTUP_CLASS="com.madhouse.dsp.metadata.ReceiveServer"

#Ueap JMX port
export JMX_PORT=9123
export CLASSPATH=$BASE_DIR/conf:$(ls $BASE_DIR/lib/*.jar | tr '\n' :)

#UEAP jvm args
UEAP_JVM_ARGS="-Dlogback.configurationFile=/services/data/dspmetadata/conf/logback.xml -Xms2g -Xmx2g -Xmn1100m -Xss256k -XX:MaxMetaspaceSize=80m -XX:MetaspaceSize=80m -XX:MaxDirectMemorySize=256m -XX:InitialCodeCacheSize=40M -XX:ReservedCodeCacheSize=50M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=75 -XX:+UseCMSInitiatingOccupancyOnly -XX:+DisableExplicitGC"
UEAP_JVM_ARGS="$UEAP_JVM_ARGS -cp $CLASSPATH -Dueap.home=$ueap_home -Dcollect.start.worker=false"

if [ -z "$UEAP_ARGS" ]; then
  export UEAP_ARGS="$UEAP_JVM_ARGS"
fi