package shell.commands;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import item.Item;
import shell.Shell;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand extends Command {
    public ReportCommand(String[] argumente) {
        super(argumente);
    }

    @Override
    public void execute() throws InvalidCommandException {
        Configuration cfg = new Configuration();

        cfg.setClassForTemplateLoading(Item.class, "/");
        cfg.setDefaultEncoding("UTF-8");

        try {
            Template template = cfg.getTemplate("report.ftl");

            Map<String, Object> templateData = new HashMap<>();
            templateData.put("name", Shell.catalog.getName());
            templateData.put("items", Shell.catalog.getItems());

            StringWriter out = new StringWriter();
            template.process(templateData, out);
            BufferedWriter writer = new BufferedWriter(new FileWriter("report.html"));
            writer.write(out.getBuffer().toString());
            out.flush();
            writer.flush();


            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File("./report.html"));

        } catch (IOException | TemplateException exception) {
            System.err.println("Nu s-a putut genera fisierul HTML.\nMotiv: " + exception.getMessage());
        }
    }
}
