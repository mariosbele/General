window.addEventListener("load", function () {
    let max = document.getElementById("max");
    let labelElement = document.getElementById("labelmax");
    let hotelElement1 = document.getElementById("siterec");
    let hotelElement2 = document.getElementById("siterec11");
    let checkinElement = document.getElementById("checkin");
    let checkoutElement = document.getElementById("checkout");
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; //January is 0!
    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }

    today = yyyy + '-' + mm + '-' + dd;
    checkinElement.setAttribute("min", today);

    checkinElement.addEventListener("input", function () {
        checkoutElement.setAttribute("min", checkinElement.value);
    });

    max.addEventListener("input", function () {
        labelElement.innerHTML = "$" + max.value;
    });
    
    const x = this.document.getElementsByClassName("forborder1");
    for (let hotel of x) {
        hotel.style.backgroundImage = "none";
        hotel.addEventListener("click", offerChange);

        function offerChange(e) {
            hotelElement1.innerHTML=e.target.innerHTML;
        }
    }

    const y = this.document.getElementsByClassName("forborder2");
    for (let hotel of y) {
        hotel.style.backgroundImage = "none";
        hotel.addEventListener("click", offerChange);

        function offerChange(e) {
            hotelElement2.innerHTML=e.target.innerHTML;
        }
    }

    var map = null;
    var myMarker;
    var myLatlng;
  
    function initializeGMap(lat, lng) {
      myLatlng = new google.maps.LatLng(lat, lng);
  
      var myOptions = {
        zoom: 12,
        zoomControl: true,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
      };
  
      map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
  
      myMarker = new google.maps.Marker({
        position: myLatlng
      });
      myMarker.setMap(map);
    }
  
    // Re-init map before show modal
    $('#myModal').on('show.bs.modal', function(event) {
      var button = $(event.relatedTarget);
      initializeGMap(button.data('lat'), button.data('lng'));
      $("#location-map").css("width", "100%");
      $("#map_canvas").css("width", "100%");
    });
  
    // Trigger map resize event after modal shown
    $('#myModal').on('shown.bs.modal', function() {
      google.maps.event.trigger(map, "resize");
      map.setCenter(myLatlng);
    });

      
});