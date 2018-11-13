package com.br.nice.controller;

import java.io.Serializable;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UICommand;
import javax.faces.event.ActionEvent;

import com.br.nice.daoHibernate.PaginationDaoHibenate;
import com.br.nice.model.User;
import com.br.nice.service.UserService;
import com.br.nice.util.MsgFeedBackUser;

/**
 * 
 * @author cicinho
 *
 */

@ManagedBean
@SessionScoped
public class PaginationUserController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<User> users;
	private String name;

	private PaginationDaoHibenate paginationDaoHibenate;

	/**
	 * pagination stuff
	 */
	private int totalRows;
	private int firstRow;
	private int rowsPerPage;
	private int totalPages;
	private int pageRange;
	private Integer[] pages;
	private int currentPage;

	/**
	 * Creates a new instance of PaginationUserController
	 */
	public PaginationUserController() {
		paginationDaoHibenate = new PaginationDaoHibenate();
		// Set default values somehow (properties files?).
		rowsPerPage = 7; // Default rows per page (max amount of rows to be displayed at once).
		pageRange = 5; // Default page range (max amount of page links to be displayed at once).
	}

	private void loadUserList() {

		users = paginationDaoHibenate.getListUser(firstRow, rowsPerPage);
		totalRows = paginationDaoHibenate.countRows();

		// Set currentPage, totalPages and pages.
		currentPage = (totalRows / rowsPerPage) - ((totalRows - firstRow) / rowsPerPage) + 1;
		totalPages = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);
		int pagesLength = Math.min(pageRange, totalPages);
		pages = new Integer[pagesLength];

		// firstPage must be greater than 0 and lesser than totalPages-pageLength.
		int firstPage = Math.min(Math.max(0, currentPage - (pageRange / 2)), totalPages - pagesLength);

		// Create pages (page numbers for page links).
		for (int i = 0; i < pagesLength; i++) {
			pages[i] = ++firstPage;
		}
	}

	// Paging actions

	public void pageFirst() {
		page(0);
	}

	public void pageNext() {
		page(firstRow + rowsPerPage);
	}

	public void pagePrevious() {
		page(firstRow - rowsPerPage);
	}

	public void pageLast() {
		page(totalRows - ((totalRows % rowsPerPage != 0) ? totalRows % rowsPerPage : rowsPerPage));
	}

	public void page(ActionEvent event) {
		page(((Integer) ((UICommand) event.getComponent()).getValue() - 1) * rowsPerPage);
	}

	private void page(int firstRow) {
		this.firstRow = firstRow;
		loadUserList();
	}

	public List<User> getUsers() {
		if (users == null) {
			loadUserList();
		}
		return users;
	}

	public void  searchByName() {
		UserService userService = new UserService();
		users = userService.consultUser(name);
		if (this.users.size() == 0) {
			MsgFeedBackUser.AddmessageAtention("Nenhum usuário encontrado!");
		}else if (this.name == null || this.name == "") {
			MsgFeedBackUser.AddmessageAtention("Informe um nome para Realizar a pesquisa");
		}
	}

	public PaginationDaoHibenate getPaginationDaoHibenate() {
		return paginationDaoHibenate;
	}

	public void setPaginationDaoHibenate(PaginationDaoHibenate paginationDaoHibenate) {
		this.paginationDaoHibenate = paginationDaoHibenate;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageRange() {
		return pageRange;
	}

	public void setPageRange(int pageRange) {
		this.pageRange = pageRange;
	}

	public Integer[] getPages() {
		return pages;
	}

	public void setPages(Integer[] pages) {
		this.pages = pages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
