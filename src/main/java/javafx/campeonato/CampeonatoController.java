package javafx.campeonato;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CampeonatoController.
 */
public class CampeonatoController {

    /** The text area. */
    @FXML private TextArea textArea;
    
    /** The button voltar. */
    @FXML private Button button_voltar;
    
    /** The label. */
    @FXML private Label label;
    
    /** The text field. */
    @FXML private TextField textField;
    
    /** The tabela. */
    @FXML private TableView<Clube> tabela;
    
    /** The column posicao. */
    @FXML private TableColumn<Clube, Integer> columnPosicao;
    
    /** The column clube. */
    @FXML private TableColumn<Clube, String> columnClube;
    
    /** The column pontos. */
    @FXML private TableColumn<Clube, Integer> columnPontos;
    
    /** The column jogos. */
    @FXML private TableColumn<Clube, Integer> columnJogos;
    
    /** The column vitorias. */
    @FXML private TableColumn<Clube, Integer> columnVitorias;
    
    /** The column empates. */
    @FXML private TableColumn<Clube, Integer> columnEmpates;
    
    /** The column derrotas. */
    @FXML private TableColumn<Clube, Integer> columnDerrotas;
    
    /** The border pane. */
    @FXML private BorderPane borderPane;

    /** The clubes. */
    private List<Clube> clubes = new LinkedList<>();
    
    /** The map. */
    private Map<String, Clube> map = new HashMap<>();
    
    /** The observable list clubes. */
    private ObservableList<Clube> observableListClubes;

    /**
     * Gets the club.
     *
     * @return the club
     */
    //retorna clube digitado pelo usuario
    public Clube getClub(){
        return map.get(textField.getText().toLowerCase());
    }

    /**
     * Select club.
     *
     * @param actionEvent the action event
     */
    //seleciona clube e cria seu grafico de rendimento
    @FXML public void selectClub(ActionEvent actionEvent) {
        if (map.containsKey(textField.getText().toLowerCase())){
            ObservableList<PieChart.Data> dados = FXCollections.observableArrayList(
                    new PieChart.Data("Vitórias", getClub().getVitorias()),
                    new PieChart.Data("Empates", getClub().getEmpates()),
                    new PieChart.Data("Derrotas", getClub().getDerrotas())
            );

            PieChart grafico = new PieChart(dados);
            grafico.setTitle(getClub().getNome() + ": " + getClub().getPontos()
                            + " pontos em " + getClub().getJogos() + " jogos.");
            borderPane.setCenter(grafico);
            textArea.setVisible(false);
            button_voltar.setVisible(true);
        } else if (textField.getText().equals("")) {
            borderPane.setCenter(tabela);
            button_voltar.setVisible(false);
            textArea.setVisible(true);
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText("Erro ao pesquisar pelo Clube");
            alerta.setContentText("Clube '" + textField.getText() + "' não localizado em " + label.getText());
            alerta.show();
        }
    }

    /**
     * Preencher tabela.
     */
    //preenche tabela com os clubes da lista
    @FXML public void preencherTabela(){
        columnPosicao.setCellValueFactory(new PropertyValueFactory<>("posicao"));
        columnClube.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnPontos.setCellValueFactory(new PropertyValueFactory<>("pontos"));
        columnJogos.setCellValueFactory(new PropertyValueFactory<>("jogos"));
        columnVitorias.setCellValueFactory(new PropertyValueFactory<>("vitorias"));
        columnEmpates.setCellValueFactory(new PropertyValueFactory<>("empates"));
        columnDerrotas.setCellValueFactory(new PropertyValueFactory<>("derrotas"));

        observableListClubes = FXCollections.observableList(clubes);
        tabela.setItems(observableListClubes);
    }

    /**
     * Abrir 2022.
     *
     * @param actionEvent the action event
     */
    //varre informacoes do campeonato de 2022
    @FXML public void abrir2022(ActionEvent actionEvent) {
        clubes.clear();
        map.clear();
        Scanner leitor;
        try {
            leitor = new Scanner (new File("..//Campeonato_Java//arquivos//2022.csv"));
            while (leitor.hasNext()){
                String [] linha = leitor.nextLine().split(",");
                Clube c = new Clube(Integer.parseInt(linha[0]), linha[1], Integer.parseInt(linha[2]),
                        Integer.parseInt(linha[3]),
                        Integer.parseInt(linha[4]),
                        Integer.parseInt(linha[5]),
                        Integer.parseInt(linha[6]));
                clubes.add(c);
                map.put(linha[1].substring(0, linha[1].indexOf("-")).trim().toLowerCase(), c);
            }
            preencherTabela();
            selectClub(null);
            label.setText("2022");
            leitor.close();
        }
        catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Exception Dialog");
            alert.setHeaderText("File not found exception");
            alert.setContentText("Arquivo nao encontrado!");
            alert.showAndWait();
        }
        catch (Exception e) {
            System.out.println ("Falha inesperada");
        }
    }

    /**
     * Abrir 2021.
     *
     * @param actionEvent the action event
     */
    //varre informacoes do campeonato de 2021
    @FXML public void abrir2021(ActionEvent actionEvent) {
        clubes.clear();
        map.clear();
        Scanner leitor;
        try {
            leitor = new Scanner (new File("..//Campeonato_Java//arquivos//2021.csv"));
            while (leitor.hasNext()){
                String [] linha = leitor.nextLine().split(",");
                Clube c = new Clube(Integer.parseInt(linha[0]), linha[1], Integer.parseInt(linha[2]),
                        Integer.parseInt(linha[3]),
                        Integer.parseInt(linha[4]),
                        Integer.parseInt(linha[5]),
                        Integer.parseInt(linha[6]));
                clubes.add(c);
                map.put(linha[1].substring(0, linha[1].indexOf("-")).trim().toLowerCase(), c);
            }
            preencherTabela();
            selectClub(null);
            label.setText("2021");
            leitor.close();
        }
        catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Exception Dialog");
            alert.setHeaderText("File not found exception");
            alert.setContentText("Arquivo nao encontrado!");
            alert.showAndWait();
        }
        catch (Exception e) {
            System.out.println ("Falha inesperada");
        }
    }

    /**
     * Abrir 2020.
     *
     * @param actionEvent the action event
     */
    //varre informacoes do campeonato de 2020
    @FXML public void abrir2020(ActionEvent actionEvent) {
        clubes.clear();
        map.clear();
        Scanner leitor;
        try {
            leitor = new Scanner (new File("..//Campeonato_Java//arquivos//2020.csv"));
            while (leitor.hasNext()){
                String [] linha = leitor.nextLine().split(",");
                Clube c = new Clube(Integer.parseInt(linha[0]), linha[1], Integer.parseInt(linha[2]),
                        Integer.parseInt(linha[3]),
                        Integer.parseInt(linha[4]),
                        Integer.parseInt(linha[5]),
                        Integer.parseInt(linha[6]));
                clubes.add(c);
                map.put(linha[1].substring(0, linha[1].indexOf("-")).trim().toLowerCase(), c);
            }
            preencherTabela();
            selectClub(null);
            label.setText("2020");
            leitor.close();
        }
        catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Exception Dialog");
            alert.setHeaderText("File not found exception");
            alert.setContentText("Arquivo nao encontrado!");
            alert.showAndWait();
        }
        catch (Exception e) {
            System.out.println ("Falha inesperada");
        }
    }

    /**
     * Abrir 2019.
     *
     * @param actionEvent the action event
     */
    //varre informacoes do campeonato de 2019
    @FXML public void abrir2019(ActionEvent actionEvent) {
        clubes.clear();
        map.clear();
        Scanner leitor;
        try {
            leitor = new Scanner (new File("..//Campeonato_Java//arquivos//2019.csv"));
            while (leitor.hasNext()){
                String [] linha = leitor.nextLine().split(",");
                Clube c = new Clube(Integer.parseInt(linha[0]), linha[1], Integer.parseInt(linha[2]),
                        Integer.parseInt(linha[3]),
                        Integer.parseInt(linha[4]),
                        Integer.parseInt(linha[5]),
                        Integer.parseInt(linha[6]));
                clubes.add(c);
                map.put(linha[1].substring(0, linha[1].indexOf("-")).trim().toLowerCase(), c);
            }
            preencherTabela();
            selectClub(null);
            label.setText("2019");
            leitor.close();
        }
        catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Exception Dialog");
            alert.setHeaderText("File not found exception");
            alert.setContentText("Arquivo nao encontrado!");
            alert.showAndWait();
        }
        catch (Exception e) {
            System.out.println ("Falha inesperada");
        }
    }

    /**
     * Abrir 2018.
     *
     * @param actionEvent the action event
     */
    //varre informacoes do campeonato de 2018
    @FXML public void abrir2018(ActionEvent actionEvent) {
        clubes.clear();
        map.clear();
        Scanner leitor;
        try {
            leitor = new Scanner(new File("..//Campeonato_Java//arquivos//2018.csv"));
            while (leitor.hasNext()){
                String [] linha = leitor.nextLine().split(",");
                Clube c = new Clube(Integer.parseInt(linha[0]), linha[1], Integer.parseInt(linha[2]),
                        Integer.parseInt(linha[3]),
                        Integer.parseInt(linha[4]),
                        Integer.parseInt(linha[5]),
                        Integer.parseInt(linha[6]));
                clubes.add(c);
                map.put(linha[1].substring(0, linha[1].indexOf("-")).trim().toLowerCase(), c);
            }
            preencherTabela();
            selectClub(null);
            label.setText("2018");
            leitor.close();
        }
        catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Exception Dialog");
            alert.setHeaderText("File not found exception");
            alert.setContentText("Arquivo nao encontrado!");
            alert.showAndWait();
        }
        catch (Exception e) {
            System.out.println ("Falha inesperada");
        }
    }

    /**
     * Voltar tela.
     *
     * @param actionEvent the action event
     */
    //volta tela para as caracteristicas iniciais da aplicacao
    @FXML public void voltarTela(ActionEvent actionEvent) {
        borderPane.setCenter(tabela);
        textArea.setVisible(true);
        button_voltar.setVisible(false);
        textField.setText("");

    }



}