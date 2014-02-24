#!/bin/sh

pathmunge() {
    CP=$CP:$1
}

AllJars=$(find . -name *.jar -print)
for f in $AllJars;
do
{
    pathmunge $f
}
done

pathmunge ./conf
pathmunge ./resources
pathmunge .

java -Xmx512m -cp $CP com.topcoder.umltool.deploy.UMLToolDeploy $1 $2 $3 $4
