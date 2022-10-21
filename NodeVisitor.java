/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
public abstract class NodeVisitor {
	public abstract void visitProduct(Product product);
	public abstract void visitTrading(Trading trading);
	public abstract void visitFacade(Facade facade);
	
}
