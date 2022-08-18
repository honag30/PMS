function resetForm(tag) {
    document.getElementById(tag).reset();
}

$.fn.pageMe = function (opts) {
    let defaults = {
            perPage: 4,
            showPrevNext: false,
            hidePageNumbers: false,
        },
        settings = $.extend(defaults, opts);

    let tableMain = this;
    let perPage = settings.perPage;
    let children = tableMain.children();
    let pagerDisplay = $(".pager");
    let numRecords = children.size();
    let numPages = Math.ceil(numRecords / perPage);
    if (typeof settings.pagerSelector != "undefined") {
        pagerDisplay = $(settings.pagerSelector);
    }
    //attach 0 for pagination
    pagerDisplay.data("pagination", 0);

    if (settings.showPrevNext) {
        $('<li class=" pageNumber" id="previous"><a href="#" class="prev_link " aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>').appendTo(
            pagerDisplay
        );
    }

    let pagination = 0;
    while (numPages > pagination && settings.hidePageNumbers === false) {
        $(
            '<li class=" pageNumber"><a href="#" class="page_link current " >' + (pagination + 1) + "</a></li>"
        ).appendTo(pagerDisplay);
        pagination++;
    }

    if (settings.showPrevNext) {
        $('<li class=" pageNumber" id="next"><a href="#" class="next_link " aria-label="Next"><span aria-hidden="true" >&raquo;</span></a></li>').appendTo(pagerDisplay);
    }

    pagerDisplay.find(".page_link:first").addClass("active");


    $(".prev_link").addClass("isDisabled")

    // pagerDisplay.find(".prev_link").hide();//if at page 1 --> hide the button "Previous"

    if (numPages <= 1) {
        $(".next_link").addClass("isDisabled")
    }

    pagerDisplay.children().eq(1).addClass("active");
    children.hide();

    children.slice(0, perPage).show();

    pagerDisplay.find("li .page_link").click(
        function () {
            let clickedPage = $(this).html().valueOf() - 1;
            goTo(clickedPage, perPage);
            return false;
        });
    pagerDisplay.find("li .prev_link ").click(
        function () {
            previous();
            return false;
        });
    pagerDisplay.find("li .next_link ").click(
        function () {
            next();
            return false;
        });

    function previous() {
        let goToPage = parseInt(pagerDisplay.data("pagination")) - 1;
        goTo(goToPage);
    }

    function next() {
        let goToPage = parseInt(pagerDisplay.data("pagination")) + 1;
        goTo(goToPage);
    }

    function goTo(page) {
        let startAt = page * perPage,
            endOn = startAt + perPage;
        children.css("display", "none").slice(startAt, endOn).show();
        if (page >= 1) {
            $(".prev_link").removeClass("isDisabled")
        } else {
            $(".prev_link").addClass("isDisabled")
        }
        if (page < numPages - 1) {
            $(".next_link").removeClass("isDisabled")
        } else {
            $(".next_link").addClass("isDisabled")
        }
        pagerDisplay.data("pagination", page);
        pagerDisplay.children().removeClass("active");
        pagerDisplay.children().eq(page + 1).addClass("active");
    }
};

if (!$(".filterable .btn-filter").prop("disabled")) {
    $(document).ready(function () {
        $('#myTable').pageMe({
            pagerSelector: '#myPager',
            showPrevNext: true,
            hidePageNumbers: false,
            perPage: 4
        });
    });
}

/**
 * Search function for table
 */
$(document).ready(
    function () {
        // Step 1
        $("#rowcount").html($(".filterable tr").length - 1);
        $("#on").hide();

        // Step 2: Make search box enable
        $(".filterable .btn-filter").click(function () {

            let parentsDivTable = $(this).parents(".filterable");
            let headerTableRow = parentsDivTable.find(".filters input");
            let bodyTale = parentsDivTable.find(".table tbody");
            let navBar = $("#navBar");
            let stickySidebar = $("#sticky-sidebar");
            let footer = $(".footer");
            let mainBodyTable = $("#main");

            if (headerTableRow.prop("disabled")) {
                navBar.wrap('<div class="blur-all">');
                stickySidebar.addClass("blur-all");
                footer.wrap('<div class="blur-all">');
                mainBodyTable.removeClass("border-left");


                $("#myPager").hide();
                $("#off").hide();
                $("#on").show();
                headerTableRow.prop("disabled", false);
                headerTableRow.first().focus();
                $("#rowcount").html($(".filterable tr").length - 1);
                $('#myTable').children().show()
            } else {
                navBar.unwrap();
                stickySidebar.removeClass("blur-all");
                footer.unwrap();
                mainBodyTable.addClass("border-left");

                $("#off").show();
                $("#on").hide();
                headerTableRow.val("").prop("disabled", true);
                $("#myPager").show();
                bodyTale.find(".no-result").remove();
                bodyTale.find("tr").show();
                $("#rowcount").html($(".filterable tr").length - 1);
                let numRecords = $('#myTable').children().size();
                $('#myTable').children().slice(4, numRecords).hide();
            }
        });

        // Step 3
        $(".filterable .filters input").keyup(function (t) {
            if ((t.keyCode || t.which)) {
                let inputBox = $(this);
                let inputBoxContent = inputBox.val().toLowerCase();
                let traceBackParent = inputBox.parents(".filterable");
                let indexNumber = traceBackParent.find(".filters th").index(inputBox.parents("th"));
                let tableObject = traceBackParent.find(".table");
                let rowOfTable = tableObject.find("tbody tr");

                //search for specific elements
                let foundRowInTable = rowOfTable.filter(function () {
                    return -1 == $(this).find("td").eq(indexNumber).text().toLowerCase().indexOf(inputBoxContent);
                });
                tableObject.find("tbody .no-result").remove(), rowOfTable.show(), foundRowInTable.hide(), foundRowInTable.length == rowOfTable.length &&
                tableObject.find("tbody").prepend(
                    $(
                        '<tr class="no-result text-center text-danger">' +
                        '<td colspan="' +
                        tableObject.find(".filters th").length +
                        '">No result found</td>' +
                        '</tr>'
                    )
                );
            }
            $("#rowcount").html($("tr:visible").length - 1),
                checkIsEmptyList()

        });
    }
);

function checkIsEmptyList() {
    if (1 === $("tbody tr:visible").length &&
        "No result found" === $("tbody tr:visible td").html()) {
        $("#rowcount").html("0");
    } else {
        $("#rowcount").html($("tr:visible").length - 1);
    }
}
