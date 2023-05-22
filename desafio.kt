enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val numeroDocumento: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
	fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
	}
    
    fun printAlunosMatriculados() {
        println("Alunos matriculados no curso de $nome: ")
		inscritos.forEach { aluno ->
        	println(aluno.nome)
        }
    }
}

fun main() {
    
    val java = ConteudoEducacional("Java", 70, Nivel.INTERMEDIARIO)
    val kotlin1 = ConteudoEducacional("Kotlin 1", 80, Nivel.BASICO)
    val kotlin2 = ConteudoEducacional("Kotlin 2", 100, Nivel.INTERMEDIARIO)
    val kotlin3 = ConteudoEducacional("Kotlin 3", 100, Nivel.DIFICIL)
    val conteudo = listOf<ConteudoEducacional>()
    conteudo.plus(listOf(java, kotlin1, kotlin2, kotlin3 ))
    val formacaoKotlin = Formacao("Formacao em Kotlin", conteudo, Nivel.INTERMEDIARIO)
    val Aluno = Usuario("Thiago", "1111122299")
    val Aluno2 = Usuario("Renato", "33333322299")
    formacaoKotlin.matricular(Aluno, Aluno2)
    formacaoKotlin.printAlunosMatriculados()
}