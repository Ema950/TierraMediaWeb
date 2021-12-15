package model;
public class NullUser extends Administrador{
	public static Administrador build() {
		return new NullUser();
	}
	
	public NullUser() {
		super("", "");
	}
	
	@Override
	public boolean isNull() {
		return true;
	}
	

}
