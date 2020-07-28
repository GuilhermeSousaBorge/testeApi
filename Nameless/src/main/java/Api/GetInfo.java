package Api;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.json.JSONObject;
import Api.Request;
import Api.JsonParser;;

public class GetInfo {

	private JLabel nomePokemon;
	private JLabel Peso;
	private JLabel Altura;
	private JLabel ID;
	private JLabel isDefault;
	private JLabel icone;

	public GetInfo(String nome) throws IOException {
		String url = String.format("https://pokeapi.co/api/v2/pokemon/%s", nome);
		Request api = new Request(url);
		JSONObject item = JsonParser.parseToObject(api.executar());

		nomePokemon = new JLabel("Nome: \n" + item.getString("name"));
		nomePokemon.setBounds(50, 0, 200, 50);

		Peso = new JLabel("\nPeso: \n" + item.getInt("weight"));
		Peso.setBounds(50, 25, 200, 70);

		Altura = new JLabel("\nAltura: \n" + item.getInt("height"));
		Altura.setBounds(50, 50, 200, 70);

		ID = new JLabel("\niD: \n" + item.getInt("id"));
		ID.setBounds(50, 75, 200, 70);
		int IDicone =  item.getInt("id");
		

		isDefault = new JLabel("\nis_default: \n" + item.getBoolean("is_default"));
		isDefault.setBounds(50, 100, 200, 70);
		
		icone = pegarIcone(IDicone);
		
	}
	


	private static JLabel pegarIcone(int fotoId) throws MalformedURLException, IOException {
		String fotoUrl = String.format("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/%d.png", fotoId);
		JLabel icone = new JLabel("");
		Image imagem = ImageIO.read(new URL(fotoUrl));
		int larguraImagem = imagem.getWidth(null);
		int alturaImagem = imagem.getHeight(null);
		icone.setIcon(new ImageIcon(imagem));
		icone.setBounds(150, 150, larguraImagem, alturaImagem);
		return icone;
	}

	public JLabel getNomePokemon() {
		return nomePokemon;
	}

	public void setNomePokemon(JLabel nomePokemon) {
		this.nomePokemon = nomePokemon;
	}

	public JLabel getPeso() {
		return Peso;
	}

	public void setPeso(JLabel peso) {
		Peso = peso;
	}

	public JLabel getAltura() {
		return Altura;
	}

	public void setAltura(JLabel altura) {
		Altura = altura;
	}

	public JLabel getID() {
		return ID;
	}

	public void setID(JLabel iD) {
		ID = iD;
	}

	public JLabel getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(JLabel isDefault) {
		this.isDefault = isDefault;
	}
	

	public JLabel getIcone() {
		return icone;
	}


	public void setIcone(JLabel icone) {
		this.icone = icone;
	}

}
