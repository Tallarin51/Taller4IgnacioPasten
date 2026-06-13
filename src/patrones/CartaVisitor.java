package patrones;

import dominio.*;

public interface CartaVisitor {
	
	int visitarPokemon(CartaPokemon carta);
	
	int visitarItem(CartaItem carta);
	
	int visitarSupporter(CartaSupporter carta);
	
	int visitarEnergy(CartaEnergy carta);
	
}
