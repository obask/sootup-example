import sootup.core.inputlocation.AnalysisInputLocation
import sootup.core.model.SootClass
import sootup.core.model.SootMethod
import sootup.core.model.SourceType
import sootup.core.signatures.MethodSignature
import sootup.core.types.ClassType
import sootup.java.bytecode.inputlocation.PathBasedAnalysisInputLocation
import sootup.java.core.JavaProject
import sootup.java.core.JavaSootClass
import sootup.java.core.JavaSootClassSource
import sootup.java.core.language.JavaLanguage
import java.nio.file.Paths
import java.util.*


fun main(args: Array<String>) {
    println("Hello World!")

    val inputLocation: AnalysisInputLocation<JavaSootClass> =
        PathBasedAnalysisInputLocation(Paths.get("build/classes/java/main/"), SourceType.Application)

    val language = JavaLanguage(17)

    val project: JavaProject = JavaProject.builder(language).addInputLocation(inputLocation).build()

    val classType: ClassType = project.identifierFactory.getClassType("HelloWorld")
//
//    val methodSignature: MethodSignature = project
//        .identifierFactory
//        .getMethodSignature(classType, "someMethod", "void", Collections.emptyList())
//
    val view = project.createView()

    val sootClass: SootClass<JavaSootClassSource> = view.getClassOrThrow(classType)

    val method = sootClass.methods.drop(1).first().body

    println(method.stmts)

//    val sootMethod: SootMethod = sootClass.getMethod().get()

//    sootMethod.body.getStmts()
}