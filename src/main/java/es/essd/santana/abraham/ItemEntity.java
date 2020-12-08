package es.essd.santana.abraham;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class ItemEntity {

	private long id;
	private String name;
	private boolean checked;

	public ItemEntity() {
		this("default", false);
	}

	public ItemEntity(String name) {
		this(name, false);
	}

	public ItemEntity(String name, boolean checked) {
		this.name = name;
		this.checked = checked;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean getChecked() {
		return checked;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", checked=" + checked + " ]";
	}
}
