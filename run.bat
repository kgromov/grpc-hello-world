SET SOURCE_DIR="./src/main/resources"
SET TARGET_DIR="./src/main/java"

protoc --plugin=protoc-gen-grpc-java=%GRPC_JAVA%\protoc-gen-grpc-java-1.53.0.exe^
 -I=%SOURCE_DIR% --java_out=%TARGET_DIR%^
 --grpc-java_out=%TARGET_DIR% %SOURCE_DIR%/hello_world.proto
