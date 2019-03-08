# Use the Garbage First (G1) Collector (recommended for prodution systems)
# https://docs.oracle.com/cd/E40972_01/doc.70/e40973/cnf_jvmgc.htm#autoId2
export JAVA_OPTS="$JAVA_OPTS -XX:+UseG1GC"

# Tells the HotSpot VM to generate a heap dump when an allocation from the
# Java heap or the permanent generation cannot be satisfied.
# https://docs.oracle.com/javase/7/docs/webnotes/tsg/TSG-VM/html/clopts.html#gbzrr
export JAVA_OPTS="$JAVA_OPTS -XX:-HeapDumpOnOutOfMemoryError"

# Sets the file encoding format
# https://docs.oracle.com/javase/8/docs/technotes/guides/intl/encoding.doc.html
export JAVA_OPTS="$JAVA_OPTS -Dfile.encoding=UTF-8"
