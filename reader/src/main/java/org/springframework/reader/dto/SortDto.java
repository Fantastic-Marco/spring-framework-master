package org.springframework.reader.dto;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/1/14 16:02
 */

public class SortDto {
	private Integer id;
	private Integer weight;

	public SortDto(Integer id, Integer weight) {
		this.id = id;
		this.weight = weight;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "SortDto{" +
				"id=" + id +
				", weight=" + weight +
				'}';
	}
}
