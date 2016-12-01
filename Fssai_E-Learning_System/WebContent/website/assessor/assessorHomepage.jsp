
    <section>
       <%@ include file="topMenuAssessor.jspf"%>
        </section>

    <!-- main body -->
    <section class="main-section-margin-top">
          <div class="container-fluid">
        <div id="wrapper"> 

              <!-- Sidebar -->
           	<%@include file="leftMenuAssessor.jspf" %>
              <!-- /#sidebar-wrapper --> 
              <!-- Page Content -->
              <div id="page-content-wrapper">
            <div class="container-fluid"> 

                  <!-- vertical button -->
                  <div class="row">
                <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Training Partner</span> </a> </div>
              </div>

                  <!-- add the content here for main body --> 
                  <!-- timeline  -->

                  <div class="container-fluid">
                <div class="row"> 

                      <!-- upcoming trainings -->
                      <div class="col-xs-12 collapse in table-overflow-responsive" id="show-result" aria-expanded="true" style="">
                    <fieldset>
                          <legend><h3>Upcoming Assessment</h3></legend>

                    <!-- table -->
                    <div class="row">
                          <div class="col-xs-12">
                        <table class="table table-bordered table-responsive table-striped table-hover">
                              <thead>
                            <tr class="background-open-vacancies">
                                  <th>S.No</th>
                                  <th>Traning Course Name</th>
                                  <th>Training Date</th>
                                  <th>Training Course Address</th>
                                  <th>No. Of Participants</th>
                                </tr>
                          </thead>
                              <tbody>
                            <tr>
                                  <td>1</td>
                                  <td>HACCP Course for Oil & Fat Industry</td>
                                  <td>10/10/2016</td>
                                  <td>Karol Bagh, New Delhi, 110011</td>
                                  <td>60</td>
                                </tr>
                            <tr>
                                  <td>2</td>
                                  <td>GHP-GMP* Certification Course</td>
                                  <td>20/09/2016</td>
                                  <td>FDA Bhavan, New Delhi</td>
                                  <td>70</td>
                                </tr>
                            <tr>
                                  <td>3</td>
                                  <td>GHP-GMP-HACCP Certification Course for Manufacturing Sector</td>
                                  <td>10/12/2016</td>
                                  <td>Chankyapuri, New Delhi</td>
                                  <td>28</td>
                                </tr>
                          </tbody>
                            </table>
                        </div>
                        </div>
                        <button type="submit" class="btn login-btn pull-right show-details-vacancy collapsed">Accept</button>
                          </fieldset>               
                  </div>
                    </div>
              </div>
                </div>
          </div>
        </div>
      </div>
        </section>