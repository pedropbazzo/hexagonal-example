var BookmarkProxy = {

	url : "http://localhost:8080/api/bookmarks",

	findAll : function() {
		return $.ajax({
			type : "GET",
			url : this.url			
		});
	},

	load : function(id) {
		return $.ajax({
			type : "GET",
			url : this.url + "/" + id
		});
	},

	insert : function(bookmark) {
		return $.ajax({
			type : "POST",
			url : this.url,
			data : JSON.stringify(bookmark),
			contentType : "application/json"
		});
	},

	update : function(id, bookmark) {
		return $.ajax({
			type : "PUT",
			url : this.url + "/" + id,
			data : JSON.stringify(bookmark),
			contentType : "application/json"
		});
	},

	remove : function(ids) {
		return $.ajax({
			type : "DELETE",
			url : this.url,
			data : JSON.stringify(ids),
			contentType : "application/json"
		});
	}
};
