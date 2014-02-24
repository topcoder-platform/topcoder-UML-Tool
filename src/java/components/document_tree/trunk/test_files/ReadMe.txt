Demo

There are two demonstrations provided:
(1) DemoTests
(2) FrameDemo

You may run FrameDemo with ant script like this
    <target name="rundemo" depends="compile_tests">
        <java classname="com.topcoder.gui.trees.document.FrameDemo" fork="true" spawn="false"
                output="${testlogdir}/demo_output.txt" error="${testlogdir}/demo_error.txt">
            <classpath location="${build_testclassdir}" />
            <classpath refid="test.build.classpath" />
        </java>
    </target>
It shows new (1.1) look by default, but you can change it to old: go to
FrameDemo.NAMESPACE and change value as described in the comment.