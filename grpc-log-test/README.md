
### Useful commands 

##### Install Proto on Mac
```
brew install protobuf
brew install protoc-gen-g
brew install protoc-gen-go-grpc
```

##### Compile Proto Files
To be run in project dir

```
protoc --go_out=. --go_opt=paths=source_relative --go-grpc_out=. --go-grpc_opt=paths=source_relative grpc-log-test/basic.proto
```