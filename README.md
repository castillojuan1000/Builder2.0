# Builder2.0

The only build tool that allows you to pass in a repo and build your project, while getting extensive metadata tied to your shippable product. There's no need to frantically track down build info if something goes wrong. Know who built it, in what directory, on what machine, at what time. Never not know again.

## Prerequisites ##
* Picocli -  A framework for creating Java command line applications with almost zero code
* GraalVM (Native Image Generator) - Compiles native executive files


## Get Started ##
Run builder init [repo url] on a project (must be a compatible language). This creates a new project with a hidden, logs, workspace, and artifact dir.

For compatible compiled languages (C#, Golang, Java) a builder.yaml file gets created (see below for more info) in the workspace dir. Golang and C# are not supported at the moment; however they will be implemented soon. 


