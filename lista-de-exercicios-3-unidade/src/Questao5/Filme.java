package Questao5;

public class Filme {
    private String titulo;
    private int duracao;
    private String audio;
    private String legenda;

    public Filme(String titulo, int duracao, String audio, String legenda){
        this.titulo = titulo;
        this.duracao = duracao;
        this.audio = audio;
        this.legenda = legenda;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setDuracao(int duracao){
        this.duracao = duracao;
    }
    public int getDuracao(){
        return duracao;
    }
    public void setAudio(String audio){
        this.audio = audio;
    }
    public String getAudio(){
        return audio;
    }
    public void setLegenda(String legenda){
        this.legenda = legenda;
    }
    public String getLegenda(){
        return legenda;
    }

    public String getDuracaoHorasMinutos(){
        duracao = getDuracao();
        String duracaoHorasMinutos = null;
        if(duracao < 60){
            duracaoHorasMinutos = duracao + " minutos";
        }
        else{
            int hora = duracao / 60;
            int minuto = duracao % 60;

            if(hora == 1){
                duracaoHorasMinutos = hora + " hora e " + minuto + " minutos";
            }
            else{
                duracaoHorasMinutos = hora + " horas e " + minuto + " minutos";
            }
        }
        return duracaoHorasMinutos;
    }
    public String getDescricao(){
        return "O filme " + getTitulo() + " possui " + getDuracaoHorasMinutos() + " de duração."; 
    }

    public static void main(String[] args) {

        Filme [] filmes = new Filme [6];
        
        filmes [0] = new Filme("Titanic", 194, "Original", "Sim");
        filmes [1] = new Filme("Os Vingadores", 182, "Original", "Não");
        filmes [2] = new Filme("Shrek", 89, "Dublado", "Sim");
        filmes [3] = new Filme("Barbie: Escola de Princesas", 81, "Dublado", "Sim");
        filmes [4] = new Filme("O Guarda-Costas", 129, "Original", "Sim");
        filmes [5] = new Filme("Homem-Aranha: Sem Volta para Casa", 148, "Original", "Não");

        System.out.println();
        System.out.println("--- Filmes com Áudio Original ---");
        for(int i = 0; i < filmes.length; i++){
            if(filmes[i].getAudio() == "Original"){
                System.out.println(filmes[i].getDescricao());
            }
        }

        System.out.println();
        System.out.println("--- Filmes com Legenda ---");
        for(Filme filme: filmes){
            if(filme.getLegenda().equals("Sim")){
                System.out.println(filme.getDescricao());
            }
        }
        double duracaoFilmes = 0;
        double mediaDuracaoFilmes = 0;
        for(int i = 0; i < filmes.length; i++){
            duracaoFilmes = duracaoFilmes + filmes[i].getDuracao();
            mediaDuracaoFilmes = duracaoFilmes / filmes.length;
        }
            System.out.println();
            System.out.println("--- Filmes com duração superior à duração média de todos os filmes ---");
            for(Filme filme: filmes){
                if(filme.getDuracao() > mediaDuracaoFilmes){
                    System.out.println(filme.getDescricao());
            }
        }
    }
}
