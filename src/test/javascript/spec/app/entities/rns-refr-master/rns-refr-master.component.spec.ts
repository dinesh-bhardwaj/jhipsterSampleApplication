/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_REFR_MASTERComponent } from '../../../../../../main/webapp/app/entities/rns-refr-master/rns-refr-master.component';
import { RNS_REFR_MASTERService } from '../../../../../../main/webapp/app/entities/rns-refr-master/rns-refr-master.service';
import { RNS_REFR_MASTER } from '../../../../../../main/webapp/app/entities/rns-refr-master/rns-refr-master.model';

describe('Component Tests', () => {

    describe('RNS_REFR_MASTER Management Component', () => {
        let comp: RNS_REFR_MASTERComponent;
        let fixture: ComponentFixture<RNS_REFR_MASTERComponent>;
        let service: RNS_REFR_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_REFR_MASTERComponent],
                providers: [
                    RNS_REFR_MASTERService
                ]
            })
            .overrideTemplate(RNS_REFR_MASTERComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_REFR_MASTERComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_REFR_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new RNS_REFR_MASTER(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.rNS_REFR_MASTERS[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
