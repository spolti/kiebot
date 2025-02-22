package org.kiegroup.kogibot.cli;

import java.io.IOException;

import org.kiegroup.kogibot.cli.KogibotCli.HelpCommand;
import org.kiegroup.kogibot.cli.commands.BackportCommand;
import org.kiegroup.kogibot.cli.commands.CloseCommand;
import org.kiegroup.kogibot.cli.commands.PullRequestScopedCommands;
import org.kiegroup.kogibot.cli.commands.wip.OpenCommand;
import org.kiegroup.kogibot.cli.commands.wip.TestCommand;
import org.kohsuke.github.GHEventPayload;

import com.github.rvesse.airline.annotations.Cli;
import com.github.rvesse.airline.annotations.Command;

import io.quarkiverse.githubapp.command.airline.AbstractHelpCommand;
import io.quarkiverse.githubapp.command.airline.CliOptions;
import io.quarkiverse.githubapp.command.airline.CommandOptions;

@Cli(
        name = "@bot",
        commands = {
                BackportCommand.class,
                CloseCommand.class,
                OpenCommand.class,
                TestCommand.class,
                HelpCommand.class
        }, description = "Kogibot main CLI. Run `/bot help` or `@bot help` for getting all available commands.")
@CliOptions(
        defaultCommandOptions = @CommandOptions(scope = CommandOptions.CommandScope.PULL_REQUESTS),
        aliases = { "@kogibot", "@kogitobot", "/bot", "/kogibot", "/kogitobot" })
class KogibotCli {

    @Command(name = "help", description = "Print help")
    static class HelpCommand extends AbstractHelpCommand implements PullRequestScopedCommands {

        @Override
        public void run(GHEventPayload.IssueComment issueCommentPayload) throws IOException {
            super.run(issueCommentPayload);
        }
    }
}
