package edu.ukma;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

@AutoService(Processor.class)
@SupportedAnnotationTypes("edu.ukma.GenerateClass")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GenerateClassAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(GenerateClass.class)) {
            GenerateClass generateClass = element.getAnnotation(GenerateClass.class);

            String className = "Generated" + element.getSimpleName();
            String methodName = generateClass.methodName();


            String packageName = "edu.ukma.generated";
            String classContent = "package " + packageName + ";\n\n" +
                    "public class " + className + " {\n\n" +
                    "    public void " + methodName + "() {\n" +
                    "        System.out.println(\"" + methodName + " called\");\n" +
                    "    }\n" +
                    "}\n";

            try {
                JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(packageName + "." + className);
                try (Writer writer = builderFile.openWriter()) {
                    writer.write(classContent);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
