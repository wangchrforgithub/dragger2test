package com.example;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

/**
 *
 * http://blog.csdn.net/industriously/article/details/53932425
 *
 * 会在编译的时候，调用该类，调用process进行解析
 */
@SupportedAnnotationTypes("com.example.MyAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class MyProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        writeFile(generateClassStr(roundEnv));
        System.out.println(" process ============  !!");
        return true;
    }

    private void writeFile(StringBuilder builder) {
        try { // write the file
            JavaFileObject source = processingEnv.getFiler().createSourceFile("com.example.administrator.myannotation.generated.GeneratedMyClass");

            Writer writer = source.openWriter();
            writer.write(builder.toString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
        }
    }

    private StringBuilder generateClassStr(RoundEnvironment roundEnv) {
        StringBuilder builder = new StringBuilder()
                .append("package com.example.administrator.myannotation.generated;\n\n")
                .append("public class GeneratedMyClass {\n\n") // open class
                .append("\tpublic String getMessage() {\n") // open method
                .append("\t\treturn \"");

        // for each javax.lang.model.element.Element annotated with the CustomAnnotation
        for (Element element : roundEnv.getElementsAnnotatedWith(MyAnnotation.class)) {
            //获得有MyAnnotation注解的元素
            String objectType = element.getSimpleName().toString();

            //getMessage的返回方法
            builder.append(objectType).append(" says hello!\\n");
        }

        builder.append("\";\n") // end return
                .append("\t}\n") // close method
                .append("}\n"); // close class

        return builder;
    }
}
