import re

def solution(new_id):
    step1 = new_id.lower()
    step2 = re.sub(r"[^a-z0-9-_.]", "", step1)
    step3 = re.sub(r"\.{2,}", ".", step2)
    step4 = re.sub(r"^\.|\.$", "", step3)
    step5 = "a" if len(step4) == 0 else step4
    step6 = re.sub(r"\.$", "", step5[:15])
    step7 = (step6 + step6[-1] * 2)[:3] if len(step6) <= 2 else step6
    return step7