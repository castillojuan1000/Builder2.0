package com.github.castillojuan1000;

import com.github.castillojuan1000.Cmds.Init;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import com.github.castillojuan1000.Utils.GetMetadata;

@Command(name = "builder", description = "...",
        mixinStandardHelpOptions = true, subcommands = {Init.class}
)
public class BuilderCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(BuilderCommand.class, args);
        System.exit(0);
    }

    public void run() {
        // business logic here

            System.out.println("Hello World.");
            GetMetadata.getBuildMetadata();

    }
}
