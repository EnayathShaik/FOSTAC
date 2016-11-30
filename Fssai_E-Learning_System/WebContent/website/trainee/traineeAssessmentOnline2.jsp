<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<%System.out.print("trainee home page jsp"); %>
<script src="website/js/jquery.js"></script> 
<cf:form action="submitAssessment.fssai" name="myForm" method="POST" commandName="traineeAssessmentOnline" >
	<section>
			<h2>Best wishes for the assessment
			</h2>
		<div class="row"> <div class="col-md-12  col-xs-12"><h3>Assessment Questions</h3>  <div id="questionsTable"></div></div></div>
		
			<script >
				var questionsList = ${traineeAssessment};
			</script>
				
			<script >
			var questionList = ${traineeAssessment};
			$(window).load(function () {
				$('#questionsTable').append('<ol>');
				for(var index=0;index<questionList.listAssessmentQuestion.length;index++){
					$('#questionsTable').append('<li><strong>Question No.'+questionList.listAssessmentQuestion[index].questionNumber+':</strong>'+questionList.listAssessmentQuestion[index].questionTitle+' </li>')
					
					//var noOption=questionList.listAssessmentQuestion[index].noOfOption;
					var noOption=6;
					$('#questionsTable').append('<table width="200" border="0">');
					for(var noOptionIndex=1; noOptionIndex<=noOption; noOptionIndex++){
						var questionOption = "option";
						var value= "";
						switch(noOptionIndex){
						case 1:
							value = "One";
							break;
						case 2:
							value = "Two";
							break;
						case 3:
							value = "Three";
							break;
						case 4:
							value = "Four";
							break;
						case 5:
							value = "Five";
							break;
						case 6:
							value = "Six";
							break;
						}
						questionOption += value;
						var questionListRow = questionList.listAssessmentQuestion[index];
						$('#questionsTable').append('<tr><td>'+noOptionIndex+')</td> <td><input name="'+questionListRow.questionNumber+'" type="radio" value="'+questionListRow[questionOption]'"></td><td>'+questionListRow[questionOption]+'</td></tr>')
					}
					$('#questionsTable').append('</table>');
				}
				$('#questionsTable').append('</ol>')
				
			});
			 </script>
			 <button class="btn login-btn pull-right">Save</button>
	</section>
</cf:form>