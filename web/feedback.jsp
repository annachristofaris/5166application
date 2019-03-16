<%@page contentType="text/html" pageEncoding="UTF-8"%>
           <div class="row justify-content-center">
                <div class="row">
                    <a href="./myItems.jsp"><i class="fas fa-plus-circle"> Save to Your Corner</i></a>
                    <div class="col-8">
                    <!-- placeholder for average rating -->
                    <i action="CatalogController?action=rating&rating=1&value=${detailItem.itemCode}" class="fas fa-star one"></i>
                    <i action="CatalogController?action=rating&rating=2&value=${detailItem.itemCode}" class="fas fa-star two"></i>
                    <i action="CatalogController?action=rating&rating=3&value=${detailItem.itemCode}" class="fas fa-star three"></i>
                    <i action="CatalogController?action=rating&rating=4&value=${detailItem.itemCode}" class="fas fa-star four"></i><br>
                    <span>Rating: ${detailItem.rating}</span>
                    
                    <form action="CatalogController?action=rating&value=${detailItem.itemCode}" method="post">
<!--                        <input type="checkbox" name="newRating" value="1"/><i class="fas fa-star one"></i>
                        <input type="checkbox" name="newRating" value="2"/><br><i class="fas fa-star two"></i>
                        <input type="checkbox" name="newRating" value="3"/><br><i class="fas fa-star three"></i>
                        <input type="checkbox" name="newRating" value="4"/><br><i class="fas fa-star four"></i>-->
                        <select name="newRating">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                        <input type="submit" />
                    </form>

                </div>
                </div>
 </div>

<!--Script for ratings and making stars clickable-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script>

    $('.fa-star.one').click(function() {
      $('.fa-star').removeClass('starfill');
      $('.fa-star.one').addClass('starfill');
    });
    
    $('.fa-star.two').click(function() {
      $('.fa-star').removeClass('starfill');
      $('.fa-star.one, .fa-star.two').addClass('starfill');
    });
    
    $('.fa-star.three').click(function() {
      $('.fa-star').removeClass('starfill');
      $('.fa-star.one, .fa-star.two, .fa-star.three').addClass('starfill');
    });
    
    $('.fa-star.four').click(function() {
      $('.fa-star').removeClass('starfill');
      $('.fa-star.one, .fa-star.two, .fa-star.three, .fa-star.four').addClass('starfill');
    });
   
    </script>