package es.essd.santana.abraham;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class OrderEntity {

	private long id;
	private String title;
	private List<ItemEntity> items;

	public OrderEntity() {
		this("Default title");
	}

	public OrderEntity(String title) {
		this(title, new ArrayList<ItemEntity>());
	}

	public OrderEntity(String title, List<ItemEntity> items) {
		this.title = title;
		this.items = items;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	@OneToMany(cascade = CascadeType.ALL)
	public List<ItemEntity> getItems() {
		return items;
	}

	public int getItemsCount() {
		return items.size();
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

	public void setItemChecked(long itemId, boolean status) {
		findItemById(itemId).ifPresent(item -> item.setChecked(status));
	}

	protected void setItemsCount(int items) {
	}

	public void addItem(String value) {
		items.add(new ItemEntity(value, false));
	}

	public void addItems(List<String> values) {
		values.stream().forEach(this::addItem);
	}

	private Optional<ItemEntity> findItemById(long itemId) {
		return items.parallelStream().filter(elem -> elem.getId() == itemId).findAny();
	}

	public void deleteItemById(long itemId) {
		findItemById(itemId).ifPresent(item -> items.remove(item));
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", title=" + title + ", items=" + getItemsCount() + "]";
	}

}
