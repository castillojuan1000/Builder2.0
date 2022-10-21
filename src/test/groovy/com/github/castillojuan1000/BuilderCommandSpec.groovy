package com.github.castillojuan1000

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class BuilderCommandSpec extends Specification {

    @Shared @AutoCleanup ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    void "test builder init command"() {
        given:
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        PrintStream out = System.out
        System.setOut(new PrintStream(baos))

        String[] args = ["init", "-n", "--name"] as String[]
        PicocliRunner.run(BuilderCommand, ctx, args)
        out.println baos.toString()

        expect:
        baos.toString().contains("init command running...")
    }
}

